package com.keyblock;

import com.keyblock.model.SSOSession;
import com.keyblock.model.TxReceipt;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Handles connection with SSOSession smart contract
 */
public interface SSOSessionInterface {

    /**
     * Create a session for a user, non blocking.
     * @param ssoSession the SSOSession object to be created
     * @return the transaction hash
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public String createSession(SSOSession ssoSession) throws IOException, ExecutionException, InterruptedException;

    /**
     * Revoke a session. Set end validity date to zero for the user current session. Non blocking
     * @param subjectAddress the ethereum address of subject to be revoked
     * @return the transaction hash
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public String revokeSession(String subjectAddress) throws IOException, ExecutionException, InterruptedException;

    /**
     * Create a session for a user. Blocking until transaction is validated
     * @param ssoSession
     * @return the transaction receipt
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public TxReceipt createSessionSync(SSOSession ssoSession) throws IOException, ExecutionException, InterruptedException;

    /**
     * Revoke a session. Set end validity date to zero for the user current session. Blocking until transaction is validated
     * @param subjectAddress the ethereum address of subject to be revoked
     * @return the transaction hash
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public TxReceipt revokeSessionSync(String subjectAddress) throws IOException, ExecutionException, InterruptedException;

    /**
     * Get the current sso session for a user
     * @param subjectAddress the subject address
     * @return the related SSOSession
     * @throws Exception
     */
    public SSOSession getSession(String subjectAddress) throws Exception;

}
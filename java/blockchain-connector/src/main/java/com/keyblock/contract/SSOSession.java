package com.keyblock.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class SSOSession extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506118ec806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631fa5d6a4146100515780636f0dccba1461006d5780638c8e13b91461009d578063dc1b058b146100cd575b600080fd5b61006b6004803603810190610066919061103d565b6100fd565b005b6100876004803603810190610082919061115b565b6103a5565b604051610094919061129b565b60405180910390f35b6100b760048036038101906100b2919061103d565b6107d7565b6040516100c4919061140a565b60405180910390f35b6100e760048036038101906100e2919061142c565b610a5c565b6040516100f49190611492565b60405180910390f35b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508173ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146101d1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101c8906114f9565b60405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff168160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610263576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161025a90611565565b60405180910390fd5b6000816004015490504282600401819055506001826000016040516102889190611685565b9081526020016040518091039020600080820160006102a79190610cb0565b6001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556002820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600382016000905560048201600090556005820160006103159190610cf0565b50507f26372039e9b9d76124333c21780d8f3bffc11594f0b8429c66146d05f1fe63d58260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168360020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684600301548460405161039894939291906116ba565b60405180910390a1505050565b606060008060008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050600073ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061050357503373ffffffffffffffffffffffffffffffffffffffff168160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156104f35750600073ffffffffffffffffffffffffffffffffffffffff168160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b80156105025750428160040154115b5b610542576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161053990611797565b60405180910390fd5b8787826000019190610555929190610d30565b50858160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550338160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055504281600301819055508481600401819055508383826005019190610601929190610db6565b5080600189896040516106159291906117eb565b90815260200160405180910390206000820181600001908054610637906115b4565b610642929190610e3c565b506001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506002820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060038201548160030155600482015481600401556005820181600501908054610739906115b4565b610744929190610ec9565b509050507f7df0a1e899ee3257ecc2bec498eeee1a019cec8ed34ebf53ff9cbd5d8d5158218633428860405161077d94939291906116ba565b60405180910390a187878080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509150509695505050505050565b6107df610f56565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206040518060c001604052908160008201805461083a906115b4565b80601f0160208091040260200160405190810160405280929190818152602001828054610866906115b4565b80156108b35780601f10610888576101008083540402835291602001916108b3565b820191906000526020600020905b81548152906001019060200180831161089657829003601f168201915b505050505081526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016002820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600382015481526020016004820154815260200160058201805461098c906115b4565b80601f01602080910402602001604051908101604052809291908181526020018280546109b8906115b4565b8015610a055780601f106109da57610100808354040283529160200191610a05565b820191906000526020600020905b8154815290600101906020018083116109e857829003601f168201915b5050505050815250509050600073ffffffffffffffffffffffffffffffffffffffff16816020015173ffffffffffffffffffffffffffffffffffffffff161415610a525780915050610a57565b809150505b919050565b60008060018484604051610a719291906117eb565b90815260200160405180910390206040518060c0016040529081600082018054610a9a906115b4565b80601f0160208091040260200160405190810160405280929190818152602001828054610ac6906115b4565b8015610b135780601f10610ae857610100808354040283529160200191610b13565b820191906000526020600020905b815481529060010190602001808311610af657829003601f168201915b505050505081526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016002820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016003820154815260200160048201548152602001600582018054610bec906115b4565b80601f0160208091040260200160405190810160405280929190818152602001828054610c18906115b4565b8015610c655780601f10610c3a57610100808354040283529160200191610c65565b820191906000526020600020905b815481529060010190602001808311610c4857829003601f168201915b5050505050815250509050806000015181604001518260200151604051602001610c919392919061187d565b6040516020818303038152906040528051906020012091505092915050565b508054610cbc906115b4565b6000825580601f10610cce5750610ced565b601f016020900490600052602060002090810190610cec9190610fb8565b5b50565b508054610cfc906115b4565b6000825580601f10610d0e5750610d2d565b601f016020900490600052602060002090810190610d2c9190610fb8565b5b50565b828054610d3c906115b4565b90600052602060002090601f016020900481019282610d5e5760008555610da5565b82601f10610d7757803560ff1916838001178555610da5565b82800160010185558215610da5579182015b82811115610da4578235825591602001919060010190610d89565b5b509050610db29190610fb8565b5090565b828054610dc2906115b4565b90600052602060002090601f016020900481019282610de45760008555610e2b565b82601f10610dfd57803560ff1916838001178555610e2b565b82800160010185558215610e2b579182015b82811115610e2a578235825591602001919060010190610e0f565b5b509050610e389190610fb8565b5090565b828054610e48906115b4565b90600052602060002090601f016020900481019282610e6a5760008555610eb8565b82601f10610e7b5780548555610eb8565b82800160010185558215610eb857600052602060002091601f016020900482015b82811115610eb7578254825591600101919060010190610e9c565b5b509050610ec59190610fb8565b5090565b828054610ed5906115b4565b90600052602060002090601f016020900481019282610ef75760008555610f45565b82601f10610f085780548555610f45565b82800160010185558215610f4557600052602060002091601f016020900482015b82811115610f44578254825591600101919060010190610f29565b5b509050610f529190610fb8565b5090565b6040518060c0016040528060608152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff1681526020016000815260200160008152602001606081525090565b5b80821115610fd1576000816000905550600101610fb9565b5090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061100a82610fdf565b9050919050565b61101a81610fff565b811461102557600080fd5b50565b60008135905061103781611011565b92915050565b60006020828403121561105357611052610fd5565b5b600061106184828501611028565b91505092915050565b600080fd5b600080fd5b600080fd5b60008083601f84011261108f5761108e61106a565b5b8235905067ffffffffffffffff8111156110ac576110ab61106f565b5b6020830191508360018202830111156110c8576110c7611074565b5b9250929050565b6000819050919050565b6110e2816110cf565b81146110ed57600080fd5b50565b6000813590506110ff816110d9565b92915050565b60008083601f84011261111b5761111a61106a565b5b8235905067ffffffffffffffff8111156111385761113761106f565b5b60208301915083600182028301111561115457611153611074565b5b9250929050565b6000806000806000806080878903121561117857611177610fd5565b5b600087013567ffffffffffffffff81111561119657611195610fda565b5b6111a289828a01611079565b965096505060206111b589828a01611028565b94505060406111c689828a016110f0565b935050606087013567ffffffffffffffff8111156111e7576111e6610fda565b5b6111f389828a01611105565b92509250509295509295509295565b600081519050919050565b600082825260208201905092915050565b60005b8381101561123c578082015181840152602081019050611221565b8381111561124b576000848401525b50505050565b6000601f19601f8301169050919050565b600061126d82611202565b611277818561120d565b935061128781856020860161121e565b61129081611251565b840191505092915050565b600060208201905081810360008301526112b58184611262565b905092915050565b600082825260208201905092915050565b60006112d982611202565b6112e381856112bd565b93506112f381856020860161121e565b6112fc81611251565b840191505092915050565b61131081610fff565b82525050565b61131f816110cf565b82525050565b600081519050919050565b600082825260208201905092915050565b600061134c82611325565b6113568185611330565b935061136681856020860161121e565b61136f81611251565b840191505092915050565b600060c083016000830151848203600086015261139782826112ce565b91505060208301516113ac6020860182611307565b5060408301516113bf6040860182611307565b5060608301516113d26060860182611316565b5060808301516113e56080860182611316565b5060a083015184820360a08601526113fd8282611341565b9150508091505092915050565b60006020820190508181036000830152611424818461137a565b905092915050565b6000806020838503121561144357611442610fd5565b5b600083013567ffffffffffffffff81111561146157611460610fda565b5b61146d85828601611079565b92509250509250929050565b6000819050919050565b61148c81611479565b82525050565b60006020820190506114a76000830184611483565b92915050565b7f4e6f2073657373696f6e20666f756e6420666f72207375626a65637400000000600082015250565b60006114e3601c8361120d565b91506114ee826114ad565b602082019050919050565b60006020820190508181036000830152611512816114d6565b9050919050565b7f4f6e6c79206973737565722063616e207265766f6b6520612073657373696f6e600082015250565b600061154f60208361120d565b915061155a82611519565b602082019050919050565b6000602082019050818103600083015261157e81611542565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806115cc57607f821691505b602082108114156115e0576115df611585565b5b50919050565b600081905092915050565b60008190508160005260206000209050919050565b60008154611613816115b4565b61161d81866115e6565b9450600182166000811461163857600181146116495761167c565b60ff1983168652818601935061167c565b611652856115f1565b60005b8381101561167457815481890152600182019150602081019050611655565b838801955050505b50505092915050565b60006116918284611606565b915081905092915050565b6116a581610fff565b82525050565b6116b4816110cf565b82525050565b60006080820190506116cf600083018761169c565b6116dc602083018661169c565b6116e960408301856116ab565b6116f660608301846116ab565b95945050505050565b7f43616e6e6f74206f7665727269646520616e206578697374696e672076616c6960008201527f642073657373696f6e206372656174656420627920616e6f746865722070726f60208201527f7669646572000000000000000000000000000000000000000000000000000000604082015250565b600061178160458361120d565b915061178c826116ff565b606082019050919050565b600060208201905081810360008301526117b081611774565b9050919050565b82818337600083830152505050565b60006117d283856115e6565b93506117df8385846117b7565b82840190509392505050565b60006117f88284866117c6565b91508190509392505050565b600061180f82611202565b61181981856115e6565b935061182981856020860161121e565b80840191505092915050565b60008160601b9050919050565b600061184d82611835565b9050919050565b600061185f82611842565b9050919050565b61187761187282610fff565b611854565b82525050565b60006118898286611804565b91506118958285611866565b6014820191506118a58284611866565b60148201915081905094935050505056fea2646970667358221220d491b5c985593fb37512e031f34ab534d52aba98d48fb4502e17c94408ca593764736f6c63430008090033";

    public static final String FUNC_CREATESESSION = "createSession";

    public static final String FUNC_GETSESSION = "getSession";

    public static final String FUNC_GETSESSIONHASHDATA = "getSessionHashData";

    public static final String FUNC_REVOKESESSION = "revokeSession";

    public static final Event SESSIONCREATED_EVENT = new Event("SessionCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SESSIONREVOKED_EVENT = new Event("SessionRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected SSOSession(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SSOSession(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SSOSession(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SSOSession(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<SessionCreatedEventResponse> getSessionCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SESSIONCREATED_EVENT, transactionReceipt);
        ArrayList<SessionCreatedEventResponse> responses = new ArrayList<SessionCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SessionCreatedEventResponse typedResponse = new SessionCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.issuer = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.issuanceDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.endValidityDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SessionCreatedEventResponse> sessionCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SessionCreatedEventResponse>() {
            @Override
            public SessionCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SESSIONCREATED_EVENT, log);
                SessionCreatedEventResponse typedResponse = new SessionCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.issuer = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.issuanceDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.endValidityDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SessionCreatedEventResponse> sessionCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SESSIONCREATED_EVENT));
        return sessionCreatedEventFlowable(filter);
    }

    public List<SessionRevokedEventResponse> getSessionRevokedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SESSIONREVOKED_EVENT, transactionReceipt);
        ArrayList<SessionRevokedEventResponse> responses = new ArrayList<SessionRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SessionRevokedEventResponse typedResponse = new SessionRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.issuer = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.issuanceDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.initialEndValidityDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SessionRevokedEventResponse> sessionRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SessionRevokedEventResponse>() {
            @Override
            public SessionRevokedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SESSIONREVOKED_EVENT, log);
                SessionRevokedEventResponse typedResponse = new SessionRevokedEventResponse();
                typedResponse.log = log;
                typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.issuer = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.issuanceDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.initialEndValidityDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SessionRevokedEventResponse> sessionRevokedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SESSIONREVOKED_EVENT));
        return sessionRevokedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createSession(String sessionId, String subject, BigInteger endValidityDate, byte[] signature) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATESESSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(sessionId), 
                new org.web3j.abi.datatypes.Address(160, subject), 
                new org.web3j.abi.datatypes.generated.Uint256(endValidityDate), 
                new org.web3j.abi.datatypes.DynamicBytes(signature)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Session> getSession(String subject) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSESSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, subject)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Session>() {}));
        return executeRemoteCallSingleValueReturn(function, Session.class);
    }

    public RemoteFunctionCall<byte[]> getSessionHashData(String sessionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSESSIONHASHDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(sessionId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeSession(String subject) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKESESSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, subject)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SSOSession load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SSOSession(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SSOSession load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SSOSession(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SSOSession load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SSOSession(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SSOSession load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SSOSession(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SSOSession> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SSOSession.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SSOSession> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SSOSession.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SSOSession> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SSOSession.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SSOSession> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SSOSession.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Session extends DynamicStruct {
        public String sessionId;

        public String subject;

        public String issuer;

        public BigInteger issuanceDate;

        public BigInteger endValidityDate;

        public byte[] signature;

        public Session(String sessionId, String subject, String issuer, BigInteger issuanceDate, BigInteger endValidityDate, byte[] signature) {
            super(new org.web3j.abi.datatypes.Utf8String(sessionId),new org.web3j.abi.datatypes.Address(subject),new org.web3j.abi.datatypes.Address(issuer),new org.web3j.abi.datatypes.generated.Uint256(issuanceDate),new org.web3j.abi.datatypes.generated.Uint256(endValidityDate),new org.web3j.abi.datatypes.DynamicBytes(signature));
            this.sessionId = sessionId;
            this.subject = subject;
            this.issuer = issuer;
            this.issuanceDate = issuanceDate;
            this.endValidityDate = endValidityDate;
            this.signature = signature;
        }

        public Session(Utf8String sessionId, Address subject, Address issuer, Uint256 issuanceDate, Uint256 endValidityDate, DynamicBytes signature) {
            super(sessionId,subject,issuer,issuanceDate,endValidityDate,signature);
            this.sessionId = sessionId.getValue();
            this.subject = subject.getValue();
            this.issuer = issuer.getValue();
            this.issuanceDate = issuanceDate.getValue();
            this.endValidityDate = endValidityDate.getValue();
            this.signature = signature.getValue();
        }
    }

    public static class SessionCreatedEventResponse extends BaseEventResponse {
        public String subject;

        public String issuer;

        public BigInteger issuanceDate;

        public BigInteger endValidityDate;
    }

    public static class SessionRevokedEventResponse extends BaseEventResponse {
        public String subject;

        public String issuer;

        public BigInteger issuanceDate;

        public BigInteger initialEndValidityDate;
    }
}

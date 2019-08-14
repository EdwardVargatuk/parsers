package ed.tasks.parsers.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 12.08.2019 20:44
 *
 * @author Edward
 */
public class Server implements FallibleWithInners {

    @JsonProperty("Number")
    private int number;

    @JsonProperty("Node_name")
    private String ip;

    @JsonProperty("Transaction_passed")
    private boolean transactionPassed;

    @JsonProperty("Node_list")
    private List<Node> nodeList;

    public Server() {
    }

    public Server(int number, String ip, List<Node> nodeList) {
        this.number = number;
        this.ip = ip;
        this.nodeList = nodeList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isTransactionPassed() {
        return transactionPassed;
    }

    public void setTransactionPassed(boolean transactionPassed) {
        this.transactionPassed = transactionPassed;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public String toString() {
        return "\n" + "Server{" +
                "number=" + number +
                ", ip='" + ip + '\'' +
                ", transactionPassed=" + transactionPassed +
                ", \nnodeList=" + nodeList +
                '}';
    }
}

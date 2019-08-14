package ed.tasks.parsers.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 12.08.2019 20:44
 *
 * @author Edward
 */
public class Cluster implements FallibleWithInners {

    @JsonProperty("Server_list")
    private List<Server> serverList;

    @JsonProperty("Transaction_passed")
    private boolean transactionPassed;

    @JsonProperty("Flops")
    private double flops;

    public Cluster() {
    }

    public Cluster(List<Server> serverList, double flops) {
        this.serverList = serverList;
        this.flops = flops;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

    public boolean isTransactionPassed() {
        return transactionPassed;
    }

    public void setTransactionPassed(boolean transactionPassed) {
        this.transactionPassed = transactionPassed;
    }

    public double getFlops() {
        return flops;
    }

    public void setFlops(double flops) {
        this.flops = flops;
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "serverList=" + serverList +
                ", flops=" + flops +
                '}';
    }
}

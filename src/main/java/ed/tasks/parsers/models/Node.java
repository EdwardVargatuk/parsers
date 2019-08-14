package ed.tasks.parsers.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 12.08.2019 20:44
 *
 * @author Edward
 */
public class Node implements FallibleWithInners {

    @JsonProperty("Number")
    private int number;

    @JsonProperty("Node_name")
    private String name;

    @JsonProperty("Transaction_passed")
    private boolean transactionPassed;

    public Node() {
    }

    public Node(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTransactionPassed() {
        return transactionPassed;
    }

    public void setTransactionPassed(boolean transactionPassed) {
        this.transactionPassed = transactionPassed;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", transactionPassed=" + transactionPassed +
                '}';
    }
}

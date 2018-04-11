package dk.skat.rsu.b2b.sample.mvc;

/**
 * Receipt
 *
 * @author SKAT
 * @since 1.0
 */
public class Receipt {

    private String transactionId;

    private byte[] receipt;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        return transactionId != null ? transactionId.equals(receipt.transactionId) : receipt.transactionId == null;
    }

    @Override
    public int hashCode() {
        return transactionId != null ? transactionId.hashCode() : 0;
    }
}

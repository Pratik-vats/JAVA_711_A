public class Student {
    String uid;
    String name;
    int fineAmount;
    int currentBorrowCount;

    public Student(String uid, String name, int fineAmount, int currentBorrowCount) {
        this.uid = uid;
        this.name = name;
        this.fineAmount = fineAmount;
        this.currentBorrowCount = currentBorrowCount;
    }

    public void validatePolicy() {
        if (fineAmount > 0) {
            throw new IllegalStateException("Outstanding fine exists.");
        }
        if (currentBorrowCount >= 2) {
            throw new IllegalStateException("Borrow limit exceeded.");
        }
    }

    public void incrementBorrowCount() {
        currentBorrowCount++;
    }
}
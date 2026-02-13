abstract class AbstractAssessmentFlow {

    public final void executeAssessment() {
        validate();
        prepare();
        evaluate();
        publishResult();
    }

    protected void validate() {
        System.out.println("Step 1: Validating candidate and inputs...");
    }

    protected void prepare() {
        System.out.println("Step 2: Preparing evaluation environment...");
    }

    protected abstract void evaluate();

    protected void publishResult() {
        System.out.println("Step 4: Publishing results to portal...");
    }
}

interface AutoAssessment {
    default void evaluate() {
        System.out.println("Step 3: Running automated AI-based evaluation...");
    }
}

interface ManualAssessment {
    default void evaluate() {
        System.out.println("Step 3: Running manual faculty-based evaluation...");
    }
}

class UnifiedAssessmentExecutor
        extends AbstractAssessmentFlow
        implements AutoAssessment, ManualAssessment {

    private boolean isProctored;

    public UnifiedAssessmentExecutor(boolean isProctored) {
        this.isProctored = isProctored;
    }

    @Override
    public void evaluate() {

        if (isProctored) {
            ManualAssessment.super.evaluate();
        } else {
            AutoAssessment.super.evaluate();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("=== AUTO ASSESSMENT ===");
        AbstractAssessmentFlow autoExam =
                new UnifiedAssessmentExecutor(false);
        autoExam.executeAssessment();

        System.out.println();

        System.out.println("=== MANUAL ASSESSMENT ===");
        AbstractAssessmentFlow manualExam =
                new UnifiedAssessmentExecutor(true);
        manualExam.executeAssessment();
    }
}

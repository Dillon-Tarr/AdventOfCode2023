package day19.puzzle2;

class RatingRangeSet {
    int completedRuleCountOnCurrentWorkflow = 0;
    boolean metMostRecentWorkflowCondition = false;
    final LongRange xRange, mRange, aRange, sRange;
    String resultOrNextWorkflow;

    RatingRangeSet(String resultOrNextWorkflow, long xS, long xE, long mS, long mE, long aS, long aE, long sS, long sE) {
        this.xRange = new LongRange(xS, xE);
        this.mRange = new LongRange(mS, mE);
        this.aRange = new LongRange(aS, aE);
        this.sRange = new LongRange(sS, sE);
        this.resultOrNextWorkflow = resultOrNextWorkflow;
    }

    RatingRangeSet(RatingRangeSet oldRangeSet, char categoryToChange, LongRange newRange, String nextWorkflowSinceConditionWasMet) {
        this.completedRuleCountOnCurrentWorkflow = oldRangeSet.completedRuleCountOnCurrentWorkflow;
        this.metMostRecentWorkflowCondition = true;
        this.resultOrNextWorkflow = nextWorkflowSinceConditionWasMet;
        switch (categoryToChange) {
            case 'x' -> {
                this.xRange = newRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 'm' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = newRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 'a' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = newRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 's' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = newRange;
            }
            default -> throw new RuntimeException("Invalid categoryToChange: "+categoryToChange);
        }
    }

    RatingRangeSet(RatingRangeSet oldRangeSet, char categoryToChange, LongRange newRange) {
        this.completedRuleCountOnCurrentWorkflow = oldRangeSet.completedRuleCountOnCurrentWorkflow;
        this.resultOrNextWorkflow = oldRangeSet.resultOrNextWorkflow;
        switch (categoryToChange) {
            case 'x' -> {
                this.xRange = newRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 'm' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = newRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 'a' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = newRange;
                this.sRange = oldRangeSet.sRange;
            }
            case 's' -> {
                this.xRange = oldRangeSet.xRange;
                this.mRange = oldRangeSet.mRange;
                this.aRange = oldRangeSet.aRange;
                this.sRange = newRange;
            }
            default -> throw new RuntimeException("Invalid categoryToChange: "+categoryToChange);
        }
    }

    void resetForNextWorkflow() {
        completedRuleCountOnCurrentWorkflow = 0;
        metMostRecentWorkflowCondition = false;
    }

    void resetForNextWorkflow(String nextWorkflow) {
        completedRuleCountOnCurrentWorkflow = 0;
        metMostRecentWorkflowCondition = false;
        resultOrNextWorkflow = nextWorkflow;
    }

    void incrementCompletedRuleCount() {
        completedRuleCountOnCurrentWorkflow++;
    }

}
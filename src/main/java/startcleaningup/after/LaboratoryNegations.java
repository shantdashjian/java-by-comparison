package startcleaningup.after;

import startcleaningup.before.Microscope;
import startcleaningup.before.Result;
import startcleaningup.before.Sample;

public class LaboratoryNegations {

    Microscope microscope;

    public LaboratoryNegations(Microscope microscope) {
        this.microscope = microscope;
    }

    public Result analyze(Sample sample) {
        if (microscope.isOrganic(sample)) {
            return analyzeOrganic(sample);
        } else {
            return Result.INORGANIC;
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (microscope.isHumanoid(sample)) {
            return Result.HUMANOID;
        } else {
            return Result.ALIEN;
        }
    }
}


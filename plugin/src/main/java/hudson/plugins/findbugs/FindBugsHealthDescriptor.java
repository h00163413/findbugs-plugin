package hudson.plugins.findbugs;

import hudson.plugins.analysis.core.AbstractHealthDescriptor;
import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.util.model.AnnotationProvider;

import org.jvnet.localizer.Localizable;

/**
 * A health descriptor for FindBugs build results.
 *
 * @author Ulli Hafner
 */
public class FindBugsHealthDescriptor extends AbstractHealthDescriptor {
    private static final long serialVersionUID = -3404826986876607396L;

    /**
     * Creates a new instance of {@link FindBugsHealthDescriptor} based on the
     * values of the specified descriptor.
     *
     * @param healthDescriptor the descriptor to copy the values from
     */
    public FindBugsHealthDescriptor(final HealthDescriptor healthDescriptor) {
        super(healthDescriptor);
    }

    @Override
    protected Localizable createDescription(final AnnotationProvider result) {
        if (result.getNumberOfAnnotations() == 0) {
            return Messages._FindBugs_ResultAction_HealthReportNoItem();
        }
        else if (result.getNumberOfAnnotations() == 1) {
            return Messages._FindBugs_ResultAction_HealthReportSingleItem();
        }
        else {
            return Messages._FindBugs_ResultAction_HealthReportMultipleItem(result.getNumberOfAnnotations());
        }
    }
}


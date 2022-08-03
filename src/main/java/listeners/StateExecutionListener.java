package listeners;

import com.google.auto.service.AutoService;
import commons.GlobalConstants;
import helpers.FunctionHelper;
import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

@AutoService(TestExecutionListener.class)
public class StateExecutionListener implements TestExecutionListener {

    private Logger log;

    public StateExecutionListener() {
        log = LoggerHelper.getLogger(StateExecutionListener.class);
    }

    public void testPlanExecutionStarted(TestPlan testPlan) {
        FunctionHelper.clearFileContent(GlobalConstants.getGlobalConstants().getPathLogFile());
        log.info("---Before test execution---");

    }

    public void testPlanExecutionFinished(TestPlan testPlan) {
        log.info("---After test execution---");
    }
}

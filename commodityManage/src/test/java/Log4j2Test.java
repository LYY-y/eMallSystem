import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
    public static void main(String[] args){
        Logger log = LogManager.getLogger(Log4j2Test.class);
        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.error("error level");
        log.fatal("fatal level");
    }
}

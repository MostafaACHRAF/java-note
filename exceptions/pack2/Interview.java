package pack2;

import java.time.LocalDateTime;


public class Interview {
    private static class TechnicalIssuesException extends Exception {
        @Override
        public String getMessage() {
            return "Something went wrong! Check your internet connection, and you hardware.";
        }
    }

    public static void startInterview(LocalDateTime time) throws TechnicalIssuesException {
        System.out.println("Interview started at " + time.toString());
        final boolean issue = true;
        if (issue) {
            throw new TechnicalIssuesException();
        }
    }

    public static String doInterview() {
        try {
            startInterview(LocalDateTime.now());
            return "Status:OK";
        } catch (TechnicalIssuesException e) {
            System.out.println(e.getMessage());
            return "Status:KO";
        } finally {
            System.out.println("End interview."); //This line will be executed regardless of the return statements at lines 25, and 28.
        }
        // System.out.println("Everything went well ^ ^"); //Throws 'unreachable statement' compilation error! (because of the return statement at line 25)
        //return "Status:UNKNOWN"; //Throws 'unreachable statement' compilation error! (because of the return statement at line 25)
    }

    public static void main(String... args) {
        final String interviewStatus = doInterview();
        System.out.println("Interviwe status: " + interviewStatus);
    }
}
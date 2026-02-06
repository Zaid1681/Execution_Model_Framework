import execution.api.Execution;

public class EmailExample {
    static void main(String[] args) {
        var  result = Execution.run(()->{
//            System.out.println("Sending Email......");
//            return "Email Sent";
            throw new RuntimeException("SMTP server failed.....");
        });
        if(result.isSuccess()){
            System.out.println("Result: " + result.value());
        }else{
            System.err.println("Error " + result.error().message());
        }
    }
}

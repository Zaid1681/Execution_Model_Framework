import execution.api.Execution;
import execution.api.ExecutionResult;

public class EmailExample {
    static void main(String[] args) {
//        Version -01 release example
//        var  result = Execution.run(()->{
//            return "Email Sent";
//        });
//        if(result.isSuccess()){
//            System.out.println("Result: " + result.value());
//        }else{
//            System.err.println("Error " + result.error().message());
//        }



//        Version -02 release examples
//        Synchronously
        ExecutionResult<String> syncResult = Execution.run(()->{
            System.out.println("Sending Email (synchronously) : ");
            return "Email Sent";
        }).sync();
        if(syncResult.isSuccess()){
            System.out.println("Email Sent Synchronously "+ syncResult.value());
        }else{
            System.err.println("Email Sent failed(Synchronousl) " + syncResult.error().message());
        }

//        Synchronously
        System.out.println("=>  Main thread Started");
        Execution.run(() -> {
                    System.out.println("Async task started");
                    Thread.sleep(5000);
                    System.out.println("Async task finished");
                    return "Email Sent";
                })
                .async()
                .onSuccess(result -> {
                    System.out.println("Async Result " + result);
                })
                .onFailure(error -> {
                    System.err.println("Async Failed " + error.message());
                });
        System.out.println("=>  Main thread finished");

    }
}

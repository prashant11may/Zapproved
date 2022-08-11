package Extras;

import java.util.function.Consumer;

public class RetryUtil {

    public  static  <T> T  retry(Iconsumer<T> consumer,int maxtries)
    {
        long count =0L;
        T result=null;

        while(count<=maxtries)
        {
            try {
               result= consumer.consume();
               break;
            }catch (AssertionError | Exception error)
            {
                if (count==maxtries)
                {
                    if (error instanceof AssertionError)
                    {throw new AssertionError(error);}
                    else {
                        throw new RuntimeException();
                    }
                }
                else {
                    if (error instanceof AssertionError) {
                        System.out.println("aasertion error : {} " + error.getMessage());
                    } else {
                        System.out.println("exception {} " + error.getMessage());
                    }
                    count++;
                    System.out.println("Retry # {}," + count);
                    try {

                        Thread.sleep(1000);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

            }

        }
        return result;
    }

}

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

public class S3ApacheClientExample {
    public static void main(String[] args) {
        String bucketName = "your-bucket-name";

        // Create an S3 client with Apache HTTP Client
        S3Client s3Client = S3Client.builder()
                .region(Region.US_EAST_1)  // Set your AWS region
                .httpClient(ApacheHttpClient.create()) // Use Apache HTTP Client
                .credentialsProvider(ProfileCredentialsProvider.create()) // Uses AWS credentials profile
                .build();

        // Request to list objects in the bucket
        ListObjectsV2Request listObjectsReq = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

        // Execute the request
        ListObjectsV2Response listObjectsRes = s3Client.listObjectsV2(listObjectsReq);

        // Print object names
        for (S3Object obj : listObjectsRes.contents()) {
            System.out.println("File: " + obj.key() + " | Size: " + obj.size());
        }

        // Close the S3 client
        s3Client.close();
    }
}

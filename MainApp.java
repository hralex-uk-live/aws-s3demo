package com.example.aws;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        S3Service s3Service = new S3Service();
        Scanner scanner = new Scanner(System.in);

        s3Service.listBuckets();

        System.out.print("\nEnter a bucket name to list objects: ");
        String bucketName = scanner.nextLine();

        s3Service.listObjects(bucketName);
        scanner.close();
    }
}

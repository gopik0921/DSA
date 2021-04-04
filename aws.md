
                                Amazon Web Services
Root Account
IAM -- Identity Access Management roles

Regions --> Availability Zones
                                
EC2 -- Elastic Compute Cloud  
 
AMI -- Amazon Machine Image

Instance types--> t2.micro  

Tenancy --> Shared,Dedicated Instance, Dedicated Host

Placement group --> cluster, spread, partition

Enable termination protection -->Protect against accidental termination

User data --> to do actions on instance load time

curl https://169.254.169.254/latest/meta-data --> in instance

curl https://169.254.169.254/latest/dynamic/instance-identity -->  in instance

SG -- Security Group --> Inbound Outbound rules to access instance

ICMP Ipv4 should be enabled to ping

Launch Template -- to make fast instances

Custom AMI -- For better load time

Spot Requests -- for low cost among all

On demand -- highest among all

Reserved Instances 

Scheduled Instances

Key-pairs --> to access instances

Private key --0400 permission

Elastic IPs --> billed when not in use. Constant reserved Ip

Elastic Network Interface --> we can add secondary Network interface to instance. This gives second private IP for instance


Load Balancers: 

1)Classic load balancer -- both Http and Tcp

2)Application load balancer -- Http only layer 7

3)Network load balancer -- Tcp,Udp layer 4 -- high performance

4)Gateway load balancer

Target Groups -- bunch of instances

listeners -- to route traffic based on rules

ASG -- Auto Scaling Group --> Target,Simple,Step

CloudWatch is used in ASG.


Elastic Beanstalk --> Managed service for web and worker deployments.

ECS: Elastic Container Services ECR -- Elastic Container Registry

Fargate: Serverless version of ECS

Lambda -- Lambda functions serverless

ApiGateway -- to develop Apis fast and deploy supports Lambda

X-Ray -- for log tracing

VPC -- Virtual Private Cloud in single region

Subnet -- For Avaliability zone

CIDR block--Classless Inter Domain Routing

Internet Gateway

Route Table -- one route table for subnet

Egress Only Internet Gateway -- IPv6 only

NAT Gateways -- Managed Service -- for private subnets to access internet -- need elastic IP

NAT instance

Network ACL -- to stop traffic reaching subnet

S3 -- Simple Storage Services -- Object Storage

S3 Buckets -- Key-values

S3 Versioning -- At bucket level

S3 Log Access

Web hosting using S3 -- Enable public access and Bucket policies

Obect level Logging

Encryption using AES or Amazon KMS -- Key Managment Service

Requestor Pays

Object lock -- deletion of objects not possible , should enable while creating

Event -- SNS, SQS, Lambda

S3 Prefixes

ACL --> Access Control List at both Bucket and Object level

Storage Classes

1)Amazon S3 Standard (S3 Standard) --frequently accessed data
2)Amazon S3 Intelligent-Tiering (S3 Intelligent-Tiering) --  data with unknown or changing access patterns
3)Amazon S3 Standard-Infrequent Access (S3 Standard-IA)-- long-lived, but less frequently accessed data
4)Amazon S3 One Zone-Infrequent Access (S3 One Zone-IA)-- long-lived, but less frequently accessed data
5)Amazon S3 Glacier (S3 Glacier) -- long-term archive and digital preservation
6)Amazon S3 Glacier Deep Archive (S3 Glacier Deep Archive) --long-term archive and digital preservation
7)Amazon S3 Outposts -- S3 Data on premises

S3 Lifecycle Configuration --> to change storage classes over time (transaction or expiration actions)

S3 Replication --> Same or differnt regions (versioning should be enabled for both source and destination)

Object Lock --> Bucket level only

S3 --> Eventual Consistent

Presigned URLs

Access Points  --> to give access to users or applications

S3 Glacier --> For Archives upto 40TB --> console not supported-->Encrytion is must --> archives in Vault
Expedited -- 1 to 5 minutes
Standard -- 3 to 5 hours
Bulk Retrievals -- upto 12 hours

S3 Glacier Deep Archive
Standard -- upto 12 hours
Bulk Retrievals -- upto 48 hours


IAM User -- IAM Group 

IAM Policies -- AWS Managed or Custom Managed

Inline Policy

IAM Roles -- Ec2 instance talks with S3 or database --> Cross Account access -- doesnt have any credentials

STS(Security Token Service) -- AssumeRole -- Switch role

IAM Corporate Federation -- SAML2.0

IAM Web Identity Federation -- openId like Amazon Cognito,Facebook, Google

IAM Role is not associated with IAM user

MFA -- Multi Factor Authentication




















 
















                              
                                
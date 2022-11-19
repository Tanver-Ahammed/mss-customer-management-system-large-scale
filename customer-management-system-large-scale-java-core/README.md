# <u>Reference Documentation</u>

## Hi, I am Md. Tanver Ahammed

### Java & Angular Developer (Full-Stack)
ICT, MBSTU

# **_mss-customer-management-system-large-scale_**

**Notes:**
**SaaS** (**S**oftware **A**s **A** **S**ervice) type software we handle a
large amount of user, because (**SaaS**) has user of users. When we use faster approach.<br>
_**In this project**_, I handle more than million of customer handle **Using
Thread** & **Without using Thread**

## Technology:

• **Core Java**<br>
• Mainly use **Thread**

## Requirements:

Customer processing is when we process large-scale(More than 1 millions) customers into
the database, and we store the data of the customer by using this user store customer from 
a large-scale data file(.txt), which needs to store in the system database in an optimized
way and very fast to manage easily. Then process data csv file from database (per file 100kb). 
You have to implement a process by which the user can process the file easily and 
store customer data.



## For Reading Data From .txt File & Save Data on Database:

Here, I use 3 approach for this Service

### * **In General Thread:**

**When we use In General Thread Concept**,
At that time, there is no task in Thread, so he gone dead.
In the last case alive only one thread (main thread). So, It is not efficient for this Task.<br>
[**Click Me Show The Process**](https://github.com/Tanver-Ahammed/mss-customer-management-system-large-scale/blob/main/customer-management-system-large-scale-java-core/src/com/customer/management/main/read/txt/write/db/MainClass.java)

### * **br.lines().parallel():**

When we use **BufferedReader, BaseStream**, which is in line **Multi-Thread**.
System automatic work with **Multi-Threaded** approach according your **System Thread, Processors**.
_br.lines().parallel()_  it needs a large of memory because read the file at a time.
So, it is not memory efficient. When the uploaded .txt is small, when we can
use this approach.<br>
[**Click Me Show The Process**](https://github.com/Tanver-Ahammed/mss-customer-management-system-large-scale/blob/main/customer-management-system-large-scale-java-core/src/com/customer/management/main/read/txt/write/db/StreamMain.java)

### * **Thread Pool:**

Thread pool has group of worker **Threads**. At the time, a **Thread** don't find task, The 
**Thread** is waiting for jobs and it reuse many time.

[**Click Me Show The Process**](https://github.com/Tanver-Ahammed/mss-customer-management-system-large-scale/blob/main/customer-management-system-large-scale-java-core/src/com/customer/management/main/read/txt/write/db/ThreadPoolMain.java)

## For Reading Data From Database & Save Data on .CSV File:

[**Click Me Show The Process**](https://github.com/Tanver-Ahammed/mss-customer-management-system-large-scale/blob/main/customer-management-system-large-scale-java-core/src/com/customer/management/main/fetch/db/write/csv/FetchingDataMainClass.java)<br>
Here, I use 2 approach for this Service

### * **In General Main-Thread:**

Here, I use only one Thread which is main-thread.

### * **In General Multi-Thread:**

Here, I use only one Thread which is **Multi-Thread.** It is so faster than other. 

<h1><a href="https://drive.google.com/drive/folders/1TRF2s7W4yXStEyVeZAG_bna_25D2m9eG">
My CV
</a> </h1>
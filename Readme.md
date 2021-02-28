# Government Grant Disbursement API

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Create empty Mysql db ggd **

2. Start Application**
mvn spring-boot:run


** Create Household

POST /api/household HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 3b7a4bd8-6330-fc44-deeb-6b1b96f93a2d

{
	"type":"HDB"
}

** Add a family member to household

POST /api/household/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: fc06c683-4e52-3f9a-6eaa-6090007acc99

{
	"name":"Mr Hello",
	"gender":"Female",
	"maritalStatus":"Y",
	"occupationType":"Employed",
	"spouseName":"Mrs Hello",
	"annualIncome":100,
	"dob":"1900-04-03 12:13:14"
}

** List households

GET /api/household HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 9c7b6d87-441e-0439-de0f-3eda605f8786


** Show household
GET /api/household/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 7ed0f2c0-7999-5833-4468-57bda4ce7ad7


** Search for households and recipients of grant disbursement endpoint. 
    /*
     * find Household for Student Encouragement Bonus
     */
    @GetMapping("/household/seb")
    /*
     * find Household for Family Togetherness Scheme
     */
    @GetMapping("/household/fts")
     /*
     * find Household for Elder Bonus
     */
    @GetMapping("/household/eb")    
    /*
     * find Baby Sunshine Grant
     */
    @GetMapping("/household/bsg")    
     /*
     * find YOLO GST Grant
     */  

** Delete household (Soft Delete)
DELETE /api/household/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 1143d06c-7f46-9ae5-e15d-f660ade66994
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW



** Delete household (Set householdId to null)
DELETE /api/household/1/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 1143d06c-7f46-9ae5-e15d-f660ade66994
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

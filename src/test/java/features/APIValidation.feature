Feature: API Validation Feature

Scenario Outline: Verify if post is created using CreatAPostAPI 
     Given add post payload with "<title>" "<body>" "<userId>"
     When user calls CreatAPostAPI with post http request
     Then the API call will success with status code 201
     And "<title>" "<body>" "<userId>" and "<id>" will be displayed in the response body
     
     Examples:
	|title|body |userId|id|
	|foo  |bar  |1     |101|
     
 Scenario: Verify if you can get all posts
      Given user calls GetAllPostsAPI with Get http request
      Then  the API call will success with status code 200 
      And posts details will be displayed in the response body
   
      
 Scenario Outline: Verify if you can get post by id
      Given user calls GetPostByIdAPI with "<postId>" Get http request
      Then  api call will success with status code 200 
      And post details will be displayed in the response body
      
      Examples:
      |postId|
      |3	 |
      
 Scenario Outline: Verify if you post wrong data request will fail
     Given add post payload with "<title>" only 
     When user calls CreatAPostAPI with post http request for mentioned payload
     Then call will fail with status code 500
     
      Examples:
      |title|
      |foo	|   
      
     
     
    
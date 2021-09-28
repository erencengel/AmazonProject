#This framework is created for Amazon and API tasks.
#Java8, Maven, JUnit and Cucumber framework are used.
  #First task --> Stock.feature,StockDefs.
  #Second task --> Crawl.feature, CrawlDefs.
  #Third and fourth tasks --> API.feature, APIDefs.
#ApachePOI for external file issues
#Rest Assure for API connection
#Hook class has @before and @after. @after has a special method for taking a screenshot when any test case failed.
#POM.xml manages dependencies and plugins
#configuration.properties has url and brwoser type.
#Driver and ConfigurationReader classes for Singleton Concept
#ExcelUtils for external files
#BrowserUtils for some dynamic waits
#Page Object Model as design pattern. Page object classes for keeping locators as central and to manage framework easily.
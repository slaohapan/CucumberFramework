Feature: Amazon Search
				 As a user, I should be able to search an item 
				 and the searched item should be relavant to search
				 
				 
@amazonSearch @SmokeTests		 
Scenario Outline: User is able to search multiple data set
Given I am on the amazon home page
When I search item "<items>"
And I click search
Then Searched item "<items>" should be displayed in the search bar
   
Examples: items

| items | 
| Coffee mug | 
| Pretty coffe mug |  
| Cool coffee mug |
| Cute coffe mug |
| Ugly coffee mug |
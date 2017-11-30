*** Settings ***
Library     com.crossover.automation.keywords.JobPortalKeywords
Library     Selenium2Library

***Variables***
${menuName}         FOR CANDIDATES
${hyperlinkText}    See Available Jobs

*** Keywords ***
 Open Home Page of Crossover
    Open Home Page
    Verify Home Page Open

 Open Jobs Segment
    Click Menu on Home Page     ${menuName}
    Verify Candidates Page Open
    Click Hyperlink On Candidates Page     ${hyperlinkText}
    Verify jobs Segment Open

 Focus on search input field
    Focus on search field
    Verify Field Focused






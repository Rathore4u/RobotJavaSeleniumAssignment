*** Settings ***

Resource            KeyWords.robot

Force Tags          jobsPortal priority1

Library     Selenium2Library

***Variables***
${searchTermOne}        Chief
${categoryName}         Java


*** Testcases ***
Jobs Segment Keyword Search Test Case
    [Documentation]             written by Rathore Mahipal
    ...                         This Robot suite is having test/s for searching jobs on Crossover Available Jobs Segment
    [tags]                      SearchJobs

    Open Home Page of Crossover
    Open Jobs Segment
    Focus on search input field
    Search Keyword for available jobs                ${searchTermOne}
    Reset Results
    Select Job Category from Category Filter         ${categoryName}
    Reset Results
    Navigate to Home Page using Logo
    Close Local Browser


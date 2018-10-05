An analytical tool for evaluating the processing time of client requests.
Data in file consists of 10 different service, each with 3 variations. Questions are divided into 10
types, each can belong to 20 categories, a category can have 5 sub categories.
First data line contains count S of all lines.
Every data line starts with character C (waiting time line) or D (query)
Represent query, it print out average waiting time of all records matching specific criterias.
service_id and question_type can have special value “*”, it means query match all
services/question types. In case of value “*”, no service variation nor service
category/sub-category can be specified.
Query line of type ‘D’ print out average waiting time rounded to minutes. Only matching lines
defined before query line are counted. It print out “-” if output is not defined.

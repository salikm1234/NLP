# Unit 6 - Natural Language Processing Project

## Introduction

Natural language processing (NLP) is used in many apps and devices to interact with users and make meaning of text to determine how to respond, find information, or to create new text. Your goal is to use natural language processing techniques to identify structure, patterns, and meaning in a text to have conversations with a user, execute commands, perform manipulations on the text, or generate new text.

## UML Diagram

<img width="1490" alt="Screenshot 2025-03-17 at 4 08 33 AM" src="https://github.com/user-attachments/assets/66561bce-6dc0-4ed4-8f6d-4ebf68c42c33" />


## Video

[![Thumbnail for my projet](nameOfThumbnail.png)](https://drive.google.com/file/d/1BmH8mtsLN6N2TqQRFLHKByl1lFY7Sva6/view?usp=sharing)

## Project Description

This application is designed to help users find synonyms for words using a text-based thesaurus system. The program takes a word input from the user and searches for its root form in a list of stems. If found, it retrieves and displays synonyms from a separate file. The system works by analyzing two text files:
	1.	Stems File (stems.txt) – Contains words grouped by their root forms. For example, different verb tenses (run, running, ran) are mapped to a single root word (run).
	2.	Synonyms File (synonyms.txt) – Contains lists of words with similar meanings. If the root word is found in this file, its synonyms are returned.

 
## NLP Techniques

Write a description of what natural lanugage technique (NLP) you implemented in your project. State which methods in your project are associated with this, and a brief explanation of how those methods word and how they are necessary in the NLP technique. 


This project implements stemming and synonym retrieval, two key techniques in Natural Language Processing (NLP). These techniques help process and analyze words by grouping similar variations together and finding alternative word choices.

1. Stemming (Root Word Identification)
	•	Associated Method: checkInput()
	•	How It Works:
	•	The method reads stems.txt, which maps different word forms (e.g., “running,” “ran,” “runs”) to a single root word (e.g., “run”).
	•	It splits each line of the file into word variations and a root word.
	•	If the user’s input matches any variation, the method returns the root word.
	•	If no match is found, it returns "String Not Found".

Why it’s necessary?
Stemming helps simplify word variations so that words like “running” and “ran” are treated as the same base word (“run”). This allows synonym lookup to be more effective.


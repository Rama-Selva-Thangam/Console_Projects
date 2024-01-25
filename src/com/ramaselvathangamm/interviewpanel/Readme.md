# Interview Panel Application

## Project Overview

Welcome to the Interview Panel Application, a streamlined tool designed exclusively for Interview Panel Members. This solo-developed project is tailored to enhance the interview process, providing essential features for managing candidates seamlessly.

## Project Details

- **Project Member(s):** 1
- **Target Audience:** Interview Panel Members

## Features

1. **Start Interview**: Initiate and manage interviews with ease.
2. **Show Current Candidate**: Display details of the candidate currently under consideration.
3. **Show Remaining Candidates**: Track the list of candidates yet to be interviewed.
4. **Show Total Candidates**: Get an overview of the total number of candidates in the queue.
5. **Add New Candidate**: Easily include new candidates into the interview process.

## Classes and Functions

### `Candidate`

- `candidateName`: String
- `qualification`: String
- `dateOfBirth`: String
- `yearOfPassing`: int

### `Repository`

- `repository`: Repository
- `candidateList`: Queue<Candidate>
- `totalCandidateList`: List<Candidate>

import { Answer } from "./Answer";

export interface Question {
    id: String;
    body: String;
    choices: Answer[];
    correctAnswer: Answer;
}
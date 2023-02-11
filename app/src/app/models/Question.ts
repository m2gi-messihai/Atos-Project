import { Answer } from "./Answer";

export interface Question {
    id: String;
    key: String;
    name: String;
    levelId: String;
    typeId: String;
    category: String;
    subCategory: String;
    mark: String;
    expectedTime: String;
    correctAnswerIds: String[];
    createdBy: String;
    answers: Answer[];
}
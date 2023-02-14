import { Answer } from "./Answer";

export interface Question {
    key: string;
    name: string;
    levelId: string;
    typeId: string;
    category: string;
    subCategory: string;
    mark: string;
    expectedTime: string;
    correctAnswerIds: string[];
    createdBy: string;
    answers: Answer[];
}
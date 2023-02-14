import { Question } from "./Question";

export interface GetAllQuestionsRsponseDto {
    questions: Question[]
    pageSize: number
    totalQuestions: number;
    offset: number;
    totalPages: number;
    pageNumber: number;
    last: Boolean;
}
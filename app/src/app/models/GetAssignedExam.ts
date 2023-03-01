import { Question } from "./Question";


export interface GetAssignedExamNameDto {
    examInstanceId: string;
    examDefinitionName: string
    examDuration: string;
    questionsIds: string[];

}
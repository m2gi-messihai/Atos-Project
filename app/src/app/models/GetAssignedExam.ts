import { ExamQuestion } from "./ExamQuestion";
import { Question } from "./Question";


export interface GetAssignedExamNameDto {
    examInstanceId: string;
    examDefinitionName: string
    examDuration: string;
    startTime: string;
    questions: ExamQuestion[];

}
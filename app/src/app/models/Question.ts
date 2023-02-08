import { Answer } from "./Answer";

export interface Question {
    id: String;
    name: String;
    level_id: String;
    type_id: String;
    category: String;
    sub_category: String;
    mark: String;
    expected_time: String;
    correct_answer_ids: String[];
    created_by: String;
    answers: Answer[];
}
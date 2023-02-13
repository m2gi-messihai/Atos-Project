import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map } from "rxjs";
import { Question } from "../models/Question";

@Injectable({
    providedIn: 'root'
})
export class Client {

    fetchQuestions() {

    }

    deleteQuestion(key: String) {


    }
    createQuestion(question: Question) {

    }

    addAnswer(question: Question) {

    }

}

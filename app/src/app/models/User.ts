import { Role } from "./Role";

export interface User {
    uid: string;
    firstName: string;
    lastName: string;
    birthDate: string;
    gender: string;
    email: string;
    mobileNumber: string;
    Address: string;
    roles: Role[];
}
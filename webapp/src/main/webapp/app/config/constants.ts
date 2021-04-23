const config = {
  VERSION: process.env.VERSION,
};

export default config;

export const SERVER_API_URL = process.env.SERVER_API_URL;

export const AUTHORITIES = {
  ADMIN: "ROLE_ADMIN",
  USER: "ROLE_USER",
};

export const messages = {
  DATA_ERROR_ALERT: "Internal Error",
};

export const APP_DATE_FORMAT = "DD/MM/YY HH:mm";
export const APP_TIMESTAMP_FORMAT = "DD/MM/YY HH:mm:ss";
export const APP_LOCAL_DATE_FORMAT = "DD/MM/YYYY";
export const APP_LOCAL_DATETIME_FORMAT = "YYYY-MM-DDTHH:mm";
export const APP_LOCAL_DATETIME_FORMAT_Z = "YYYY-MM-DDTHH:mm Z";
export const APP_WHOLE_NUMBER_FORMAT = "0,0";
export const APP_TWO_DIGITS_AFTER_POINT_NUMBER_FORMAT = "0,0.[00]";
export const API_KEY = "AIzaSyBeCUPgUin3BXurPzw0TLsTFwpWfh9zSuA";
export const secret = "2ad981649e693ace673ae3369a694f2d4b5cd07a39b3cf123d07969c4392204b";

#!/usr/bin/env bash

LocalBaseUrl="http://127.0.0.1:9999"
TestBaseUrl="http://18.143.173.148:9999"

BaseUrl=${LocalBaseUrl}


curl -X GET -H "Content-Type: application/json; charset=utf-8" ${BaseUrl}"/ping"

echo ""

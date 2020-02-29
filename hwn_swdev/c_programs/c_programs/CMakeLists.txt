cmake_minimum_required(VERSION 3.0)

project(c_programs LANGUAGES C)

add_executable(c_programs main.c)

install(TARGETS c_programs RUNTIME DESTINATION bin)

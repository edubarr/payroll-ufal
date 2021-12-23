package utils;

import employees.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class State {
    ArrayList<Employee> employees;
    ArrayList<Unionist> unionists;
    ArrayList<String> schedules;

    public State(ArrayList<Employee> employees, ArrayList<Unionist> unionists, ArrayList<String> schedules) {
        this.employees = new ArrayList<>(employees);
        this.unionists = new ArrayList<>(unionists);
        this.schedules = new ArrayList<>(schedules);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Unionist> getUnionists() {
        return unionists;
    }

    public ArrayList<String> getSchedules() {
        return schedules;
    }

    public static State update(ArrayList<Employee> employees, ArrayList<Unionist> unionists, ArrayList<String> schedules){
        return new State(employees, unionists, schedules);
    }

    public static State menu(Stack<State> stateNow, Stack<State> stateUndo) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                Escolha uma opção:
                1 - Desfazer última ação
                2 - Refazer última ação
                """);

        int option = input.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Desfazendo última ação...\n");
                return undo(stateNow, stateUndo);
            }
            case 2 -> {
                System.out.println("Refazendo última ação...\n");
                return redo(stateNow, stateUndo);
            }
        }
        return null;
    }

    private static State undo(Stack<State> stateNow, Stack<State> stateUndo) {
        if (stateNow.size() == 1) {
            System.out.println("Não há ação para Desfazer!\n");
            return null;
        }
        State undo = stateNow.pop();
        stateUndo.push(undo);

        return stateNow.peek();
    }

    private static State redo(Stack<State> stateNow, Stack<State> stateUndo) {
        if (stateUndo.size() == 1) {
            System.out.println("Não há ação para Refazer!\n");
            return null;
        }
        State redo = stateUndo.pop();
        stateNow.push(redo);

        return redo;
    }
}

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
        this.employees = employees;
        this.unionists = unionists;
        this.schedules = schedules;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setUnionists(ArrayList<Unionist> unionists) {
        this.unionists = unionists;
    }

    public ArrayList<Unionist> getUnionists() {
        return unionists;
    }

    public void setSchedules(ArrayList<String> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<String> getSchedules() {
        return schedules;
    }

    public static State update(State state, ArrayList<Employee> employees, ArrayList<Unionist> unionists, ArrayList<String> schedules){
        state.setEmployees(employees);
        state.setUnionists(unionists);
        state.setSchedules(schedules);

        return state;
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
                System.out.println("Desfazendo última ação...");
                return undo(stateNow, stateUndo);
            }
            case 2 -> {
                System.out.println("Refazendo última ação...");
                return redo(stateNow, stateUndo);
            }
        }
        return null;
    }

    private static State undo(Stack<State> stateNow, Stack<State> stateUndo) {
        if (stateNow.size() == 1) {
            System.out.println("Não há ação para Desfazer!");
            return null;
        }
        stateUndo.push(stateNow.pop());

        return stateNow.peek();
    }

    private static State redo(Stack<State> stateNow, Stack<State> stateUndo) {
        if (stateUndo.size() == 0) {
            System.out.println("Não há ação para Refazer!");
            return null;
        }
        State redo = stateUndo.pop();
        stateNow.push(redo);

        return redo;
    }
}

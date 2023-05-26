package controller;

import dto.request.service.CalculateRequest;
import dto.request.view.input.ItemInputRequest;
import dto.request.view.output.ResultViewRequest;
import dto.response.input.BackpackInputResponse;
import dto.response.input.ItemInputResponse;
import dto.response.service.CalculateResponse;
import service.CalculateService;
import view.input.BackpackInputView;
import view.input.ItemInputView;
import view.input.NumberOfItemInputView;
import view.output.ResultView;

public class BackpackController {
    //view
    private ItemInputView itemInputView = new ItemInputView();
    private NumberOfItemInputView numberOfItemInputView = new NumberOfItemInputView();
    private BackpackInputView backpackInputView = new BackpackInputView();
    private ResultView resultView = new ResultView();

    //service
    private CalculateService calculateService = new CalculateService();

    public void calculateStart(){
        //input
        ItemInputRequest itemInputRequest = numberOfItemInputView.getNumberOfItem();
        ItemInputResponse itemInputResponse = itemInputView.input(itemInputRequest);
        BackpackInputResponse backpackInputResponse = backpackInputView.input();

        //service
        CalculateResponse calculateResponse =
                calculateService.calculate(
                        CalculateRequest.from(itemInputResponse, backpackInputResponse)
                );

        //output
        resultView.showResult(ResultViewRequest.from(calculateResponse));
    }
}
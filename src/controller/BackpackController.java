package controller;

import dto.request.service.CalculateRequest;
import dto.request.view.input.ItemInputRequest;
import dto.request.view.output.ResultViewRequest;
import dto.response.input.BackpackInputResponse;
import dto.response.input.ItemInputResponse;
import dto.response.service.CalculateResponse;
import service.CalculateService;
import service.validation.ItemDuplicateValidation;
import view.input.BackpackInputView;
import view.input.ItemInputView;
import view.input.NumberOfItemInputView;
import view.output.ResultView;

public class BackpackController {
    //view
    private final ItemInputView itemInputView = new ItemInputView();
    private final NumberOfItemInputView numberOfItemInputView = new NumberOfItemInputView();
    private final BackpackInputView backpackInputView = new BackpackInputView();
    private final ResultView resultView = new ResultView();

    //service
    private final CalculateService calculateService = new CalculateService();
    private final ItemDuplicateValidation itemDuplicateValidation = new ItemDuplicateValidation();

    public void calculateStart() {
        //input
        ItemInputRequest itemInputRequest = numberOfItemInputView.getNumberOfItem();
        ItemInputResponse itemInputResponse = itemInputView.input(itemInputRequest);
        BackpackInputResponse backpackInputResponse = backpackInputView.input();

        itemDuplicateValidation.check(itemInputResponse.getItems());

        //service
        CalculateResponse calculateResponse =
                calculateService.calculate(
                        CalculateRequest.from(itemInputResponse, backpackInputResponse)
                );

        //output
        resultView.showResult(ResultViewRequest.from(calculateResponse));
    }
}
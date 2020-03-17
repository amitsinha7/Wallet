package com.leovegas.wallet.api.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leovegas.wallet.api.constant.WalletConstant;
import com.leovegas.wallet.api.exception.WalletException;
import com.leovegas.wallet.api.helper.TransctionValidator;
import com.leovegas.wallet.api.helper.Utils;
import com.leovegas.wallet.api.request.dto.PlayerRequest;
import com.leovegas.wallet.api.request.dto.TransactionRequest;
import com.leovegas.wallet.api.response.dto.AccountDTO;
import com.leovegas.wallet.api.response.dto.PlayerDTO;
import com.leovegas.wallet.api.response.dto.WalletResponseDTO;
import com.leovegas.wallet.api.service.WalletService;

@RestController
@RequestMapping("/v1")
public class WalletController {

	@Autowired
	private WalletService walletService;

	@Autowired
	private TransctionValidator transctionValidator;

	@Autowired
	private Utils utils;

	// Current balance per player
	@RequestMapping(value = "/player/{id}/accountinfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<WalletResponseDTO> getPlayerAccountBalance(@PathVariable("id") Long id) {

		WalletResponseDTO walletResponseDTO = new WalletResponseDTO();
		try {
			PlayerDTO playerDTO = walletService.findPlayerById(id);
			walletResponseDTO.setAccountDTO(playerDTO.getAccountDTO());
		} catch (WalletException ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.WalletException));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.EXPECTATION_FAILED);
		} catch (Exception ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.SOMETHING_WENT_WRONG));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.OK);
	}

	// Transaction history per player
	@RequestMapping(value = "/player/{id}/transactionsinfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<WalletResponseDTO> getPlayerTransactions(@PathVariable("id") Long id) {
		WalletResponseDTO walletResponseDTO = new WalletResponseDTO();
		try {
			PlayerDTO playerDTO = walletService.findPlayerById(id);
			walletResponseDTO.setTransactionDTOs(playerDTO.getAccountDTO().getTransactionDTOs());
		} catch (WalletException ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.WalletException));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.EXPECTATION_FAILED);
		} catch (Exception ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.SOMETHING_WENT_WRONG));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.OK);
	}

	// Credit And Withdrawal per player
	@RequestMapping(value = "/player/{id}/transactions", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<WalletResponseDTO> playerAccountCredit(@PathVariable("id") Long playerId,
			@RequestBody TransactionRequest transactionRequest, BindingResult validationErrors) {
		WalletResponseDTO walletResponseDTO = new WalletResponseDTO();
		try {
			transctionValidator.validateRequest(transactionRequest, validationErrors, playerId);
			if (validationErrors.hasErrors()) {
				walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.MALFORMED_REQUEST));
				return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.BAD_REQUEST);
			} else {
				AccountDTO accountDTO = walletService.accountTransactions(playerId, transactionRequest);
				walletResponseDTO.setAccountDTO(accountDTO);
			}
		} catch (InsufficientResourcesException irx) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, irx);
			walletResponseDTO
					.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.InsufficientFundException));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.INSUFFICIENT_STORAGE);
		} catch (WalletException ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);

			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.WalletException));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.EXPECTATION_FAILED);
		} catch (Exception ex) {
			Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.SOMETHING_WENT_WRONG));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.OK);
	}

	// Create Player
	@RequestMapping(value = "/player/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<WalletResponseDTO> createPlayer(@RequestBody PlayerRequest playerRequest) {
		WalletResponseDTO walletResponseDTO = new WalletResponseDTO();
		try {
			PlayerDTO playerDTO = walletService.createPlayer(playerRequest);
			walletResponseDTO.setPlayerDTO(playerDTO);
		} catch (Exception ex) {
			walletResponseDTO.setErrorInfo(utils.getErrorInfo(WalletConstant.WifiServiceError.MALFORMED_REQUEST));
			return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<WalletResponseDTO>(walletResponseDTO, HttpStatus.OK);
	}
}

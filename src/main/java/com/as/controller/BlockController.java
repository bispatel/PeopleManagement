package com.as.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.as.dao.BlockDao;
import com.as.model.Block;

@Controller
public class BlockController {
	@Autowired
	private BlockDao blockDao;

	@RequestMapping("/blocks")
	public String index(Model model) {
		List<Block> blockList = blockDao.getAllBlock();
		//Using sort method in List.
		blockList.sort((d1,d2)->d1.getBlockName().compareToIgnoreCase(d2.getBlockName()));	
		model.addAttribute("blockList", blockList);
		return "/blocks/viewBlocks";
	}

	 @RequestMapping(value = "/blockAdd")
	    public String addBlock(Model model){
	    	model.addAttribute("block", new Block());
	        return "/blocks/addEditBlock";
	    }	

	  @RequestMapping(value = "/blockEdit/{id}")
	    public String editBlock(@PathVariable("id") Integer blockId, Model model){
	    	model.addAttribute("block", blockDao.getBlock(blockId));
	        return "/blocks/addEditBlock";
	    }	    
	    
	    @RequestMapping(value = "blockUpdate", method = RequestMethod.POST)
	    public String save(Block block){
	    	block.setStatus("A");
	    	block.setLastModDate(new Timestamp(new Date().getTime()));
	    	block.setLastModBy("SYSTEM");
	    	blockDao.saveOrUpdate(block);
	    	return "redirect:/blocks";
	    }
	    
	    @RequestMapping(value = "/blockDelete/{id}", method = RequestMethod.GET)
	    public String deleteBlock(@PathVariable("id") Integer blockId, Model model) {
	    	Block block = new Block();
	    	block.setBlockId(blockId);
	    	blockDao.deleteBlock(block);
	        return "redirect:/blocks";
	    } 
}

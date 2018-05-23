package com.yugioh.block.demo.service.impl;

import com.yugioh.block.demo.entity.Block;
import com.yugioh.block.demo.entity.Business;
import com.yugioh.block.demo.service.IBlockService;
import com.yugioh.block.demo.utils.StringUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Create By lieber
 * @Description 区块服务实现
 * @Date Create in 2018/5/23 10:33
 * @Modify By
 */
@Service
public class BlockServiceImpl implements IBlockService {

    /**
     * 所有的区块
     */
    private static List<Block> blocks = null;

    @Resource
    private StringUtils stringUtils;

    @Override
    public Block generateBlock(Block prevBlock, List<Business> businesses) {
        if (businesses == null || businesses.size() == 0) {
            return null;
        }
        int index = 0;
        String prevHash = "";
        if (prevBlock != null) {
            index = prevBlock.getIndex() + 1;
            prevHash = prevBlock.getHash();
        }
        Block newBlock = new Block();
        newBlock.setIndex(index);
        newBlock.setTimestamp(System.currentTimeMillis());
        newBlock.setPrevHash(prevHash);
        newBlock.setNonceStr(stringUtils.generateRandomString(32));
        // TODO 可能会对区块业务数据信息进行加密
        newBlock.setBody(businesses);
        newBlock.setHash(this.calculateHash(newBlock));
        return newBlock;
    }

    @Override
    public String calculateHash(Block block) {
        StringBuilder sb = new StringBuilder();
        if (block != null) {
            sb.append(block.getIndex()).append(block.getTimestamp()).append(block.getPrevHash()).append(block.getNonceStr());
            List<Business> businesses = block.getBody();
            if (businesses != null && businesses.size() > 0) {
                for (Business business : businesses) {
                    sb.append(business.toString());
                }
            }
        }
        MessageDigest digest = DigestUtils.getSha256Digest();
        byte[] hash = digest.digest(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(sb.toString()));
        return Hex.encodeHexString(hash);
    }

    @Override
    public boolean isBlockValid(Block newBlock, Block oldBlock) {
        return newBlock != null && oldBlock != null
                && oldBlock.getIndex() + 1 == newBlock.getIndex()
                && oldBlock.getHash() != null && newBlock.getHash() != null
                && oldBlock.getHash().equals(newBlock.getPrevHash())
                && newBlock.getHash().equals(calculateHash(newBlock));
    }

    @Override
    public boolean putToChain(Block block) {
        if (blocks == null) {
            blocks = new ArrayList<>();
        }
        blocks.add(block);
        return true;
    }

    @Override
    public Block getLastBlock() {
        if (blocks == null || blocks.size() == 0) {
            return null;
        }
        return blocks.get(blocks.size() - 1);
    }

}

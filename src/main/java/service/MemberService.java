package service;


import dao.MemberDAO;
import domain.MemberVO;
import dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;
    private MemberDAO memberDAO;
    private ModelMapper modelMapper;
    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw)throws Exception
    {
        MemberVO vo = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo,
                MemberDTO.class);
        return memberDTO;
    }

    public void register(MemberDTO memberDTO) throws Exception{
        MemberVO vo = modelMapper.map(memberDTO, MemberVO.class);
        log.info(vo);
        memberDAO.insert(vo);
    }

    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> voList = memberDAO.selectAll();
        List<MemberDTO> memberDTOList = voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return memberDTOList;
    }

    public MemberDTO selectOne(String mid) throws Exception{
        MemberVO MemberVO = memberDAO.selectOne(mid);
        MemberDTO memberDTO = MapperUtil.INSTANCE.get().map(MemberVO, MemberDTO.class);
        return memberDTO;
    }

    public void modify(MemberDTO memberDTO) throws Exception{
        MemberVO memberVO = MapperUtil.INSTANCE.get().map(memberDTO, MemberVO.class);
        memberDAO.updateOne(memberVO);
    }

    public void remove(String mid) throws Exception{
        memberDAO.deleteOne(mid);
    }

}
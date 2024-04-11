package hong.cs.service;

import java.util.ArrayList;

import hong.cs.dto.CSDTO;

public interface CSService {
	public ArrayList<CSDTO> csSelectAll();

	public CSDTO csSelect(int cs_number);

	public CSDTO csInsert(CSDTO csDTO);

	public CSDTO csUpdate(CSDTO csDTO);

	public CSDTO csDelete(int cs_number);
}
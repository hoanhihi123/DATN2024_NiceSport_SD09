package com.example.duantn.service.impl;

import com.example.duantn.model.ChatLieu;
import com.example.duantn.model.DanhMuc;
import com.example.duantn.repository.ChatLieuRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements BaseService<ChatLieu> {
    @Autowired
    ChatLieuRepository repo_chatLieu;

//    @Override
//    public List<ChatLieu> layDanhSach() {
//        return repo_chatLieu.getAll();
//    }
//
//    @Override
//    public List<ChatLieu> findByCondition(ChatLieu entity) {
//        return null;
//    }

    @Override
    public Page<ChatLieu> layDanhSach(Pageable pageable) {
        return repo_chatLieu.getAll(pageable);
    }

    @Override
    public Page<ChatLieu> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_chatLieu.getAll(textSearch, pageable);
        }
        return repo_chatLieu.getAll(pageable);
    }

//    @Override
//    public Page<ChatLieu> findPage(ChatLieu entity, Pageable pageable) {
//        return null;
//    }

    @Override
    public void xoa(UUID id) {
        repo_chatLieu.deleteById(id);
    }

    @Override
    public void themMoi(ChatLieu entity) {
        repo_chatLieu.save(entity);
    }

    @Override
    public void capNhat(ChatLieu entity) {
         repo_chatLieu.save(entity);
    }

    @Override
    public ChatLieu chiTietTheoId(UUID id) {
        Optional<ChatLieu> chatLieu = repo_chatLieu.findById(id);
        ChatLieu chatLieu1 = chatLieu.get();
        return chatLieu1;
    }

    @Override
    public List<ChatLieu> layDanhSachTheoTen(String ten) {
        return null;
    }

    @Override
    public List<ChatLieu> layDanhSach() {
        return  repo_chatLieu.getAll();
    }


    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ChatLieu chatLieu : dsChatLieu) {
            if (chatLieu.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dsChatLieu!=null){
            for (ChatLieu chatLieu : dsChatLieu) {
                if (chatLieu.getTen().equalsIgnoreCase(tenCheck.trim())) {
                    isCheck = true;
                    break;
                }
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<ChatLieu> dsChatLieu = repo_chatLieu.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsChatLieu.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        if(dsChatLieu!=null){
            for (ChatLieu chatLieu : dsChatLieu) {
                if (chatLieu.getMa().equalsIgnoreCase(maMoi.trim())) {
                    isCheck = true;
                    break;
                }
            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }
}

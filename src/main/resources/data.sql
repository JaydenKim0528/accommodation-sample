-- 1. Hotel (호텔) 세트
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('서울 호텔', '서울 중심에 위치한 5성급 호텔로, 럭셔리한 객실과 다양한 편의 시설을 제공합니다.', 37.5665, 126.9780, 'HOTEL', 1, 'FIELD', '서울역에서 도보 5분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('부산 호텔', '부산 해운대 해변에서 가까운 럭셔리 호텔로, 최고의 해양 전망을 제공합니다.', 35.1587, 129.1603, 'HOTEL', 1, 'LOT', '해운대 해변 도보 10분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('제주 호텔', '제주 시내 중심에 위치한 모던한 호텔로, 관광 명소와 인접한 최고의 위치를 자랑합니다.', 33.5096, 126.5312, 'HOTEL', 0, 'GARAGE', '제주 시내 중심가에서 도보 5분 거리');

-- 2. Motel (모텔) 세트
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('부산 모텔', '해운대 해변 근처에 위치한 현대적이고 깔끔한 모텔로, 편리한 교통과 합리적인 가격을 자랑합니다.', 35.1587, 129.1603, 'MOTEL', 1, 'STREET', '해운대 해변 도보 3분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('서울 모텔', '서울 명동에 위치한 합리적인 가격의 모텔로, 쇼핑과 먹거리를 모두 즐길 수 있는 최적의 위치를 제공합니다.', 37.5636, 126.9820, 'MOTEL', 1, 'LOT', '명동역에서 도보 2분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('대구 모텔', '대구 시내 중심가에 위치한 접근성 좋은 모텔로, 주요 상업지구와 가까운 숙박시설입니다.', 35.8714, 128.6014, 'MOTEL', 0, 'FIELD', '대구역에서 도보 10분 거리');

-- 3. Resort (리조트) 세트
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('제주 리조트', '아름다운 제주도 해변에 위치한 5성급 리조트로, 다양한 레저 활동과 휴식을 제공합니다.', 33.4996, 126.5312, 'RESORT', 1, 'LOT', '제주 국제공항에서 차량 20분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('강릉 리조트', '동해안 최고의 전망을 자랑하는 강릉의 럭셔리 리조트로, 해변 바로 앞에 위치해 있습니다.', 37.7519, 128.8760, 'RESORT', 1, 'FIELD', '강릉역에서 차량 15분 거리');

INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text)
VALUES ('부산 리조트', '부산 기장 해안에 위치한 고급 리조트로, 다양한 해양 액티비티와 여유로운 휴식을 제공합니다.', 35.2404, 129.2133, 'RESORT', 1, 'LOT', '기장역에서 차량 10분 거리');


-- 서울 호텔 (acmd_no = 1)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/seoul_hotel/main.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/seoul_hotel/thumbnail.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/seoul_hotel/detail.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/seoul_hotel/location.jpg', 1);

-- 부산 호텔 (acmd_no = 2)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/busan_hotel/main.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/busan_hotel/thumbnail.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/busan_hotel/detail.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/busan_hotel/location.jpg', 2);

-- 제주 호텔 (acmd_no = 3)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/jeju_hotel/main.jpg', 3);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/jeju_hotel/thumbnail.jpg', 3);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/jeju_hotel/detail.jpg', 3);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/jeju_hotel/location.jpg', 3);

-- 부산 모텔 (acmd_no = 4)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/busan_motel/main.jpg', 4);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/busan_motel/thumbnail.jpg', 4);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/busan_motel/detail.jpg', 4);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/busan_motel/location.jpg', 4);

-- 서울 모텔 (acmd_no = 5)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/seoul_motel/main.jpg', 5);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/seoul_motel/thumbnail.jpg', 5);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/seoul_motel/detail.jpg', 5);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/seoul_motel/location.jpg', 5);

-- 대구 모텔 (acmd_no = 6)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/daegu_motel/main.jpg', 6);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/daegu_motel/thumbnail.jpg', 6);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/daegu_motel/detail.jpg', 6);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/daegu_motel/location.jpg', 6);

-- 제주 리조트 (acmd_no = 7)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/jeju_resort/main.jpg', 7);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/jeju_resort/thumbnail.jpg', 7);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/jeju_resort/detail.jpg', 7);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/jeju_resort/location.jpg', 7);

-- 강릉 리조트 (acmd_no = 8)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/gangneung_resort/main.jpg', 8);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/gangneung_resort/thumbnail.jpg', 8);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/gangneung_resort/detail.jpg', 8);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/gangneung_resort/location.jpg', 8);

-- 부산 리조트 (acmd_no = 9)
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/busan_resort/main.jpg', 9);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/busan_resort/thumbnail.jpg', 9);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/busan_resort/detail.jpg', 9);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/busan_resort/location.jpg', 9);


-- 일반적인 숙박 옵션(어메니티) 데이터
INSERT INTO amenity (description, name) VALUES ('방 안에 개별 에어컨이 설치되어 있습니다.', '에어컨');
INSERT INTO amenity (description, name) VALUES ('미니바 또는 큰 냉장고가 구비되어 있습니다.', '냉장고');
INSERT INTO amenity (description, name) VALUES ('넓은 욕실에 욕조가 포함되어 있습니다.', '욕조');
INSERT INTO amenity (description, name) VALUES ('모든 구역에서 무료 Wi-Fi가 제공됩니다.', '무료 Wi-Fi');
INSERT INTO amenity (description, name) VALUES ('숙소 내에 무료로 이용 가능한 주차장이 마련되어 있습니다.', '무료 주차장');
INSERT INTO amenity (description, name) VALUES ('온돌바닥이 있는 전통 한국식 객실입니다.', '온돌방');
INSERT INTO amenity (description, name) VALUES ('해변까지 도보로 5분 거리로 접근할 수 있습니다.', '해변 접근성');
INSERT INTO amenity (description, name) VALUES ('객실 내에서 TV와 케이블 방송을 시청할 수 있습니다.', 'TV 및 케이블 방송');
INSERT INTO amenity (description, name) VALUES ('피트니스 센터에서 운동을 즐길 수 있습니다.', '피트니스 센터');
INSERT INTO amenity (description, name) VALUES ('실내 수영장이 마련되어 있으며, 무료로 이용할 수 있습니다.', '실내 수영장');
INSERT INTO amenity (description, name) VALUES ('레스토랑에서 다양한 메뉴를 제공하는 아침 식사가 제공됩니다.', '조식 포함');
INSERT INTO amenity (description, name) VALUES ('24시간 운영되는 리셉션 서비스가 제공됩니다.', '24시간 리셉션');
INSERT INTO amenity (description, name) VALUES ('비즈니스 센터와 회의실이 구비되어 있습니다.', '비즈니스 센터');
INSERT INTO amenity (description, name) VALUES ('객실 내 전용 금고가 마련되어 있습니다.', '전용 금고');
INSERT INTO amenity (description, name) VALUES ('숙소 내 스파와 사우나를 이용할 수 있습니다.', '스파 및 사우나');
INSERT INTO amenity (description, name) VALUES ('바다 전망의 발코니가 있는 객실을 이용할 수 있습니다.', '발코니 및 바다 전망');


-- 서울 호텔 (acmd_no = 1) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 3);  -- 욕조
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 5);  -- 무료 주차장

-- 부산 호텔 (acmd_no = 2) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 6);  -- 피트니스 센터
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 7);  -- 발코니 및 바다 전망

-- 제주 호텔 (acmd_no = 3) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 5);  -- 무료 주차장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 8);  -- 조식 포함

-- 부산 모텔 (acmd_no = 4) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 4, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 4, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 4, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 4, 5);  -- 무료 주차장

-- 서울 모텔 (acmd_no = 5) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 5, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 5, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 5, 5);  -- 무료 주차장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 5, 9);  -- TV 및 케이블 방송

-- 대구 모텔 (acmd_no = 6) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 6, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 6, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 6, 5);  -- 무료 주차장

-- 제주 리조트 (acmd_no = 7) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 7, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 7, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 7, 4);  -- 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 7, 10); -- 실내 수영장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 7, 11); -- 스파 및 사우나

-- 강릉 리조트 (acmd_no = 8) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 8, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 8, 5);  -- 무료 주차장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 8, 2);  -- 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 8, 7);  -- 발코니 및 바다 전망

-- 부산 리조트 (acmd_no = 9) - 주요 편의시설
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 9, 1);  -- 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 9, 10); -- 실내 수영장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 9, 11); -- 스파 및 사우나
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 9, 5);  -- 무료 주차장








kaeru2:julius kaeru$ cat hello.rb
#! /usr/bin/env ruby
# -*- coding: utf-8 -*-

require "socket"
require "rubygems"
require "nokogiri"

s = nil
until s
  begin
    s = TCPSocket.open("localhost", 10500)
  rescue
    STDERR.puts "Julius �ɐڑ����s���܂���\n�Đڑ������݂܂�"
    sleep 10
    retry
  end
end
puts "Julius �ɐڑ����܂���"

source = ""
w=""
while true
  ret = IO::select([s])
  ret[0].each do |sock|
    source += sock.recv(65535)
    if source[-2..source.size] == ".\n"
      source.gsub!(/\.\n/, "")
      xml = Nokogiri(source)
      words = (xml/"RECOGOUT"/"SHYPO"/"WHYPO").inject("") {|ws, w| ws + w["WORD"] }
      unless words == ""
        puts "�u#{words}�v�� �F�����܂����B"
        if words == "������B" then
            puts "������ł���"
        else
            puts "������ł���܂���"
            puts #{words}
        end
      end
      source = ""
    end
  end
end